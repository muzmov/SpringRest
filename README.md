# SpringRest

### Инструкция по сборке и запуску
* Запустить mvn package в корневой директории скачанного проекта
* Задеплоить созданный в папке target springrest.war на сервер (протестировано на tomcat 9) любым удобным способом

### Поддерживаемые запросы
* search?email=your_email - поиск пользователя по емэйлу. 
* delete?email=your_email - удаление пользователя по емэйлу. 
* add?name=your_name&surname=second_name&email=your_email@mail.ru&password=12345&date=02_12_2005
