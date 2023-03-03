package app.products;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    Logger logger = LoggerFactory.getLogger(ProductService.class);

    public void addProduct(){
        logger.trace("A TRACE Message");
    }

    public void updateProduct(){
        logger.debug("A DEBUG Message");
    }

    public void removeProduct(){
        logger.info("An INFO Message");
    }

    public void findProductById(){
        logger.warn("A WARN Message");
    }

    public void findProductByName(){
        logger.error("An ERROR Message");
    }
}
