# Spring AI Project with OpenAI and Ollama

## Introduction

This project integrates Spring Boot with OpenAI's API and Ollama to create a powerful AI application.
The application leverages the capabilities of OpenAI for natural language processing and image generation.
Below, you'll find an overview of the project's features, setup instructions, and how to use the various functionalities.

![swigger-ui](https://github.com/user-attachments/assets/c1259017-79b9-45fc-be15-f5e966214aa6)

## Features

1. **Sentiment Analysis**
    - Analyze the sentiment of a given text and return whether it's positive, negative, or neutral.
  
    ![sentiment](https://github.com/user-attachments/assets/4a9dbc1e-bf4e-4513-af3e-b9b6e7aa7ae9)


2. **Image Description**
    - Provide a description of a given image using OpenAI's image analysis capabilities.
  
    ![describe-Image](https://github.com/user-attachments/assets/c4f8d58c-ae31-4c33-b5c9-1dab605b12e2)


3. **Image Generation**
    - Generate images based on textual descriptions using OpenAI's DALL-E model.

Test 1 : 
![generate-image2](https://github.com/user-attachments/assets/947bfe12-7af8-40e7-9b70-8fe11961ef99)

Test 2 : 

![generate-image1](https://github.com/user-attachments/assets/8cead871-7461-4b62-9334-eff71dcc1142)



3. **Chat**
![chat](https://github.com/user-attachments/assets/fffcfd15-c368-47a5-a281-d3f881b55cab)



## Setup Instructions

1. **Clone the Repository**
    ```bash
    git clone https://github.com/your-username/spring-ai-project.git
    cd spring-ai-project
    ```

2. **Configure API Keys**
    - Ensure you have your OpenAI API key and any necessary configurations for Ollama.
    - Add these keys to your `application.properties` file:
    ```properties
    openai.api.key=YOUR_OPENAI_API_KEY
    ollama.api.key=YOUR_OLLAMA_API_KEY
    ```

3. **Build and Run the Project**
    ```bash
    ./mvnw clean install
    ./mvnw spring-boot:run
    ```

## Using the Application

### Sentiment Analysis

- **Endpoint:** `/api/sentiment`
- **Method:** `POST`
- **Request Body:**
    ```json
    {
        "text": "I love this product!"
    }
    ```
- **Response:**
    ```json
    {
        "sentiment": "positive"
    }
    ```

### Image Description

- **Endpoint:** `/api/image/description`
- **Method:** `POST`
- **Request Body:**
    ```json
    {
        "imageUrl": "https://example.com/image.jpg"
    }
    ```
- **Response:**
    ```json
    {
        "description": "A beautiful sunset over the mountains."
    }
    ```

### Image Generation

- **Endpoint:** `/api/image/generate`
- **Method:** `POST`
- **Request Body:**
    ```json
    {
        "description": "A futuristic city skyline at night."
    }
    ```
- **Response:**
    ```json
    {
        "imageUrl": "https://generated-image-url.com/futuristic-city.jpg"
    }
    ```

## Contribution

Feel free to contribute to this project by opening issues or submitting pull requests. We welcome all contributions that help improve the project.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

## Acknowledgements

- [OpenAI](https://openai.com/) for their powerful AI models.
- [Ollama](https://ollama.com/) for additional AI services and support.

---

Thank you for using our Spring AI Project! If you have any questions or feedback, please don't hesitate to contact us.
