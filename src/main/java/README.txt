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

Соберите новый образ:
docker build -t blog:latest .

Остановите и удалите старый контейнер:
docker stop blog
docker rm blog

Запустите новый контейнер:
docker run -d --name demar94/blog:latest