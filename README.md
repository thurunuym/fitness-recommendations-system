
###An intelligent, microservice-based fitness recommendation system** designed to provide personalized workout and nutrition insights.

---

## ◻️ Tech Stack
![React](https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-47A248?style=for-the-badge&logo=mongodb&logoColor=white)
![Keycloak](https://img.shields.io/badge/Keycloak-000?style=for-the-badge&logo=keycloak&logoColor=white)
![RabbitMQ](https://img.shields.io/badge/RabbitMQ-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white)
![Eureka](https://img.shields.io/badge/Eureka-_?style=for-the-badge&logo=netflix&logoColor=E50914)
![Gemini API](https://img.shields.io/badge/Gemini_API-4285F4?style=for-the-badge&logo=google-gemini&logoColor=white)

* **Frontend:** React.js
* **Backend (Microservices):** Spring Boot
* **Identity & Access Management:** Keycloak
* **Service Discovery:** Eureka Server
* **Asynchronous Messaging:** RabbitMQ
* **Databases:** PostgreSQL, MongoDB 
* **AI Engine:** Google Gemini API

---
## ◻️ Architecture Overview

This project is built on a **microservices architecture** to ensure scalability, flexibility, and maintainability.

* **Eureka Server:** Acts as the service registry where all microservices register themselves, enabling dynamic service discovery and load balancing.
* **Keycloak:** Provides robust security with centralized authentication and authorization, securing endpoints and managing user roles.
* **RabbitMQ:** Facilitates asynchronous communication between microservices. For example, when a user requests a new fitness recommendation, the request is published to a queue, allowing the AI service to process it independently without blocking the main application flow.
* **Gemini API:** The core AI engine that processes user data to generate intelligent, personalized fitness recommendations.

---

## ◻️ Features

- ✅ **AI-Powered Recommendations:** Get personalized recommendations using the Gemini API.
- ✅ **Secure Authentication:** Robust user authentication and role-based access control managed by Keycloak.
- ✅ **Scalable Microservices:** A resilient backend where services can be scaled and updated independently.
- ✅ **Asynchronous Processing:** Non-blocking, efficient communication between services for a smooth user experience.


