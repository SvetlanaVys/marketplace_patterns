# Marketplace (Patterns)

### Implemented patterns
1. Builder: [CategoryDTO](https://github.com/SvetlanaVys/marketplace_patterns/blob/main/src/main/java/com/svysk/marketplace/dto/CategoryDTO.java), [ProductDTO](https://github.com/SvetlanaVys/marketplace_patterns/blob/main/src/main/java/com/svysk/marketplace/dto/ProductDTO.java)
3. Singleton:
   * single-thread: [CategoryMapper](https://github.com/SvetlanaVys/marketplace_patterns/blob/main/src/main/java/com/svysk/marketplace/mapper/CategoryMapper.java)
   * multi-thread: [ProductMapper](https://github.com/SvetlanaVys/marketplace_patterns/blob/main/src/main/java/com/svysk/marketplace/mapper/ProductMapper.java)
3. Prototype: [Category](https://github.com/SvetlanaVys/marketplace_patterns/blob/main/src/main/java/com/svysk/marketplace/model/Category.java)
4. Decorator: [/decorator](https://github.com/SvetlanaVys/marketplace_patterns/blob/main/src/main/java/com/svysk/marketplace/pattern_extra/decorator)
5. Observer: [/observer](https://github.com/SvetlanaVys/marketplace_patterns/blob/main/src/main/java/com/svysk/marketplace/pattern_extra/observer)
6. Strategy: [/strategy](https://github.com/SvetlanaVys/marketplace_patterns/blob/main/src/main/java/com/svysk/marketplace/pattern_extra/strategy)
7. Factory method: [/factory](https://github.com/SvetlanaVys/marketplace_patterns/blob/main/src/main/java/com/svysk/marketplace/pattern_extra/factory)

### Build and Run project
1. Build Project
   ```
   mvn clean install
   ```
2. Run PostgreSQL
   ```
   docker-compose up --build
   ```

### Access Swagger:
Once the application is up, you can access the Swagger UI at:
http://localhost:8080/swagger-ui/index.html
