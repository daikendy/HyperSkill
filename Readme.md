```mermaid
graph TD
    User((User Browser)) -->|HTTPS| Vercel[Vercel: Frontend UI]
    Vercel -->|REST API Calls| Render[Render: Spring Boot Backend]
    Render -->|SQL Connection| TiDB[TiDB Cloud: Quiz Database]

    subgraph "CI/CD Pipeline"
    GitHub[GitHub Repo] -->|Auto-Build| Vercel
    GitHub -->|Auto-Build| Render
    end

    ## 📸 Screenshots

| Home Screen | Live Quiz |
| :---: | :---: |
| ![Home](https://github.com/daikendy/HyperSkill/blob/dev/screenshots/home.png?raw=true) | ![Quiz](https://github.com/daikendy/HyperSkill/blob/dev/screenshots/quiz.png?raw=true) |