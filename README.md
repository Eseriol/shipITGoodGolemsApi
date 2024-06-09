# ShipITGoodGolemsApi

## Description

ShipITGoodGolemsApi is a project that implements an API for working with various data processing modules and AI integration. The project includes components for data storage, integration with vector databases, and request processing.

## Project Structure

- **good-golems-anthropic-claude**: Integration module with AI models from Anthropic.
- **good-golems-api-rest**: REST API for interacting with other modules.
- **good-golems-core**: Core components and logic of the project.
- **good-golems-domain**: Domain models and services.
- **good-golems-jpa-storage**: Components for data storage using JPA.
- **good-golems-redis**: Integration with Redis for caching.
- **good-golems-service**: Services for data processing.
- **good-golems-spi-ai-embedded-model**: Interfaces for embedded AI models.
- **good-golems-spi-ai-model**: Interfaces for external AI models.
- **good-golems-spi-storage**: Interfaces for data storage.
- **good-golems-spi-vectordb**: Interfaces for working with vector databases.

## Requirements

- Java 17 or newer
- Maven

## Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/Eseriol/shipITGoodGolemsApi.git
   ```
2. Navigate to the project directory:
   ```sh
   cd shipITGoodGolemsApi
   ```
3. Build the project using Maven:
   ```sh
   mvn clean install
   ```

## Usage

Run the application with the command:
```sh
mvn spring-boot:run
```

## License

This project is licensed under the Apache 2.0 License. See the [LICENSE](./LICENSE) file for details.

## Contact

For more information or questions, please contact us through GitHub Issues.
