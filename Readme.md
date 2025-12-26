```mermaid
graph TD
    User((User Browser)) -->|HTTPS| Vercel[Vercel: Frontend UI]
    Vercel -->|REST API Calls| Render[Render: Spring Boot Backend]
    Render -->|SQL Connection| TiDB[TiDB Cloud: Quiz Database]

    subgraph "CI/CD Pipeline"
    GitHub[GitHub Repo] -->|Auto-Build| Vercel
    GitHub -->|Auto-Build| Render
    end

    style Vercel fill:#000,color:#fff,stroke:#333
    style Render fill:#43a047,color:#fff,stroke:#333
    style TiDB fill:#007bff,color:#fff,stroke:#333
    style GitHub fill:#24292e,color:#fff,stroke:#333
```

## 📸 Screenshots

| Home Screen | Live Quiz |
| :---: | :---: |
| ![Home](https://github.com/daikendy/HyperSkill/blob/dev/screenshots/home.png?raw=true) | ![Quiz](https://github.com/daikendy/HyperSkill/blob/dev/screenshots/quiz.png?raw=true) |