Технологии:
• фреймворк Spring (MVC, Security, JPA)
• язык MySQL
• фреймворк Hibernate
• управление зависимостями Maven
• CSS-фреймворк Bootstrap
• языки разметки и стилей HTML/CSS/JS
• веб-сервер Tomcat 8
• технологии Docker и Docker-compose

Улучшение кода:
- реализация модели Order
- реализация модели Customer

Чтобы обновить программу в Docker после внесения
изменений в код, выполните следующие шаги:
-Справа вверху Maven:
clean
install
-Ввести в терминале:
docker compose up --build

Обновить Docker Hub:
Ввести в терминале:
docker login
docker push demar94/blog:latest