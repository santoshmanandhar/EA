package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDAO {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    //Clear DB
    public void clearDB() {
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        jdbcTemplate.update("DELETE from product", namedParameters);
        jdbcTemplate.update("DELETE from supplier",namedParameters);
    }
    //Save product
    public void save(Product product){
        Map<String,Object> namedParameters = new HashMap<>();
        namedParameters.put("productnumber", product.getProductNumber());
        namedParameters.put("name",product.getName());
        namedParameters.put("price", product.getPrice());
        jdbcTemplate.update("INSERT INTO product VALUES(:productnumber, :name, :price)", namedParameters);

        //Save Supplier
        Map<String,Object> namedParametersSupplier = new HashMap<>();
        namedParametersSupplier.put("productNumber",product.getProductNumber());
        namedParametersSupplier.put("name",product.getSupplier().getName());
        namedParametersSupplier.put("phone",product.getSupplier().getPhone());
        jdbcTemplate.update("INSERT INTO supplier VALUES(:name, :phone,:productNumber)", namedParametersSupplier);



    }

    //Get All Products
    public List<Product> getAllProducts(){
        List<Product> products =jdbcTemplate.query("SELECT * from product",
                new HashMap<String, Product>(),
                (rs,rowNum) -> new Product(rs.getInt("productnumber"),
                                            rs.getString("name"),
                                            rs.getDouble("price")));

        for (Product product: products){
            Supplier supplier = getSupplierForProduct(product.getProductNumber());
            product.setSupplier(supplier);
        }

        return products;
    }

    Supplier getSupplierForProduct(int productNumber){
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        namedParameters.put("productNumber", productNumber);
        Supplier supplier = jdbcTemplate.queryForObject("SELECT * FROM supplier WHERE "
                        + "productNumber =:productNumber ",
                namedParameters,
                (rs, rowNum) -> new Supplier( rs.getString("name"),
                        rs.getString("phone")));

        return supplier;
    }


    //REMOVE PRODUCT
    public void removeProduct(int productNumber){
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("productNumber", productNumber);
        jdbcTemplate.update("DELETE FROM product WHERE " + "productNumber=:productNumber", namedParameters);
        System.out.println("Product with product number " + productNumber + " has been removed successfully.");

    }

    //GET PRODUCT BY PRODUCT NUMBER
    public Product getProductByProdNumber(int productNumber){
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("productNumber", productNumber);
        Product product = jdbcTemplate.queryForObject("SELECT * FROM product WHERE "+  "productNumber=:productNumber", namedParameters,
                (rs, rowNum) -> new Product(rs.getInt("productnumber"),
                        rs.getString("name"),
                        rs.getDouble("price")));
        Supplier supplier = getSupplierForProduct(product.getProductNumber());
        product.setSupplier(supplier);
        return product;

    }

    //GET PRODUCT BY PRODUCT NAME
    public Product getProductByProdName(String name){
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("name", name);
        Product product = jdbcTemplate.queryForObject("SELECT * FROM product WHERE "+  "name=:name", namedParameters,
                (rs, rowNum) -> new Product(rs.getInt("productnumber"),
                        rs.getString("name"),
                        rs.getDouble("price")));
        Supplier supplier = getSupplierForProduct(product.getProductNumber());
        product.setSupplier(supplier);
        return product;

    }

}
