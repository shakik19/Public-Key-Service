# Public-Key-Service API Documentation

This document provides an overview of the API endpoints for the **Public-Key-Service** application, a Spring Boot application that manages public keys. Below are the available API endpoints, their descriptions, and the expected request and response formats.

## Endpoints

### 1. Get a Public Key by ID

**Endpoint:** `GET /key/{id}`
- Description: Retrieve a public key by its unique identifier (`id`).
- Parameters:
    - `id` (Path Variable): The unique identifier for the public key.
- Response:
    - Returns a JSON object representing the public key entity.
- HTTP Status Codes:
    - `200 OK` if the key with the specified `id` is found.
    - `404 Not Found` if the key with the specified `id` is not found.

### 2. Get Public Key History by ID

**Endpoint:** `GET /key/history/{id}`
- Description: Retrieve the history of changes for a public key by its unique identifier (`id`).
- Parameters:
    - `id` (Path Variable): The unique identifier for the public key.
- Response:
    - Returns a JSON object representing the history of changes for the specified public key.
- HTTP Status Codes:
    - `200 OK` if the history for the key with the specified `id` is found.
    - `404 Not Found` if the key with the specified `id` is not found.

### 3. Create a Public Key

**Endpoint:** `POST /key`
- Description: Create a new public key entity.
- Request Body: Expects a JSON object with the following structure:
  ```json
  {
    "id": "string",
    "public_key": "string"
  }
  ```
    - `id` (String): The unique identifier for the new public key.
    - `public_key` (String): The public key value.
- Response:
    - `202 Accepted` if the public key is created successfully.
- HTTP Status Codes:
    - `202 Accepted` if the public key is created successfully.
    - `400 Bad Request` if the `id` or key already exists.
    - `406 Not Acceptable` if the request body is missing or has invalid data.

### 4. Delete a Public Key

**Endpoint:** `DELETE /key/{id}`
- Description: Delete a public key by its unique identifier (`id`).
- Parameters:
    - `id` (Path Variable): The unique identifier for the public key to delete.
- Response:
    - `200 OK` if the public key is deleted successfully.
- HTTP Status Codes:
    - `200 OK` if the key with the specified `id` is found and successfully deleted.
    - `404 Not Found` if the key with the specified `id` is not found.

## Errors

- If an endpoint encounters an error, it will return an appropriate HTTP status code along with an error message in the response body.

## Notes

- Make sure to provide valid input data in the request body for creating a new public key.
- Ensure that the unique `id` parameter is provided and exists when retrieving, updating, or deleting public keys.

For more details on how to use these endpoints, refer to the API documentation or contact the service administrator.