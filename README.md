# Demo Custom Response Project

## Project Overview

This is a Java-based project using Jakarta EE that implements a secure data handling system with custom authorization
and sensitive data protection.

## Key Components

### DTOs (Data Transfer Objects)

- **ItemDto**: Represents item data with protected fields (price and description) using @SensitiveData annotation
- Contains basic item information including id, name, description, and price
- Implements data mapping from Item entity

### Security Features

- Custom authorization denial handling through CustomHandleAuthorizationDenied
- Sensitive data protection using @SensitiveData annotation
- Authorization result customization for different return types
- Default response "You can't see me" for unauthorized String access
- Null returns for other unauthorized data types

## Technical Stack

- Jakarta EE
- Spring Security
- Lombok for reducing boilerplate code
- Spring BeanUtils for object mapping

## Example Request
    curl --location 'http://localhost:8080/api/items' \
    --header 'CanSeeSensitiveData: true'

## Example Response
- CanSeeSensitiveData: true
    

    {
      "id": 1,
      "name": "Sample Item",
      "description": "This is a sample item description",
      "price": 29.99
    }
- CanSeeSensitiveData: false


    {
        "id": 1,
        "name": "Sample Item",
        "description": "You can't see me",
        "price": null
    }`