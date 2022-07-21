# Marketplace (Patterns)

### Implemented patterns
1. Builder: [CategoryDTO](https://github.com/SvetlanaVys/marketplace_patterns/blob/main/src/main/java/com/svysk/marketplace/dto/CategoryDTO.java), [ProductDTO](https://github.com/SvetlanaVys/marketplace_patterns/blob/main/src/main/java/com/svysk/marketplace/dto/ProductDTO.java)
3. Singleton:
   * single-thread: [CategoryMapper](https://github.com/SvetlanaVys/marketplace_patterns/blob/main/src/main/java/com/svysk/marketplace/mapper/CategoryMapper.java)
   * multi-thread: [ProductMapper](https://github.com/SvetlanaVys/marketplace_patterns/blob/main/src/main/java/com/svysk/marketplace/mapper/ProductMapper.java)
3. Prototype: [Category](https://github.com/SvetlanaVys/marketplace_patterns/blob/main/src/main/java/com/svysk/marketplace/model/Category.java)

### Build and Run project
1. Build Project
   ```
   mvn clean install
   ```
2. Run PostgreSQL
   ```
   docker compose up
   ```
