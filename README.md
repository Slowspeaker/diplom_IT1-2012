# xnkqionsbdarpbwmocho

Тестовое задание для Junior Backend Developer (Java)

# Оглавление
(1) [Как скачать](#how-to-download)
- 1.1  [Процесс запуска](#launch-process)

(2) [2](#needable-settings) 
- [Требования](#requiremnts) 
### [Конфигурация](#configuration) 


## [1](#how-to-download) Как скачать 

Чтобы скачать проект, вам нужно открыть командную строку. И прописать команду git clone https://github.com/Slowspeaker/xnkqionsbdarpbwmocho.

#### [1.1](#how-to-download) ПРОЦЕСС ЗАПУСКА.
При открытий проекта gradle сам забилдит нужные для него зависимости. Надо будет прописать `application.properties`.
Выставить нужную версию jdk. Потом запустить XnkqionsbdarpbwmochoApplication.java. Данные вставятся в таблицу бд, и можно будет давать запросы в постмане.


## [2](#needable-settings) Необходимые настройки

Чтобы настроить и запустить проект, вам необходимо следовать инструкциям ниже.

### [2.1](#requiremnts) Требования

- **Java**: Используется версия Java 17(corretto 17). Убедитесь, что она установлена и правильно настроена на вашей машине.
- **PostgreSQL**: Для базы данных используется PostgreSQL версии 15. Ниже приведены детали конфигурации:
  - **Логин**: `postgres`
  - **Пароль**: `12345`
  - **URL**: `jdbc:postgresql://localhost:5432/telephony`
- **MongoDB**: Для базы данных используется Mongodb версии 7.0.5. Ниже приведены детали конфигурации:
  - **URL**: `mongodb.uri=mongodb://@localhost:27017/telephony` 
- **Gradle**: Проект использует Gradle версии 6.8. Пожалуйста, убедитесь, что он установлен на вашей системе.

### [Конфигурация](#configuration) Конфигурация

Перед запуском проекта убедитесь, что файл `application.properties` (или `application.yml` для YAML формата) в вашем проекте содержит правильные настройки для подключения к базе данных PostgreSQL.

Пример для `application.properties` для `postgresql`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/имя_базы_данных
spring.datasource.username=ваш_логин
spring.datasource.password=ваш_пароль
spring.jpa.hibernate.ddl-auto=update


````
далее для `mongodb`:

```properties
#mongodb.uri=mongodb://@localhost:27017/имя_базы_данных
#ИЛИ
mongodb.uri=mongodb://ваш_логин:ваш_пароль@localhost:27017/имя_базы_данных
````
### [3.1](#configuration-controllers) Контроллеры


TelephonyController - управляет телефонными номерами (postgreSQL).


>POST /api/v1/from-postgres - создает запись телефонии.

>GET /api/v1/from-postgres/{id} - возвращает телефонию по ID.

>GET /api/v1/from-postgres/{phoneNumber} - возвращает телефонию по номеру телефона.

>PUT /api/v1/from-postgres/{id} - обновляет телефонию по ID.

>DELETE /api/v1/from-postgres/{id} - удаляет телефонию по ID.

>DELETE /api/v1/from-postgres/byPhoneNumber - удаляет телефонию по номеру телефона

TelephonyMongoController - управляет телефонными номерами (mongoDB).


>POST /api/v1/from-mongo - создает запись телефонии.

>GET /api/v1/from-mongo/{id} - возвращает телефонию по ID.

>GET /api/v1/from-mongo/{phoneNumber} - возвращает телефонию по номеру телефона.

>PUT /api/v1/from-mongo/{id} - обновляет телефонию по ID.

>DELETE /api/v1/from-mongo/{id} - удаляет телефонию по ID.

>DELETE /api/v1/from-mongo/byPhoneNumber - удаляет телефонию по номеру телефона

### [3.2](#configuration-resources) Ресурсы
данные для бд сохранены в папке `src/main/resources` 
для postgres -> telephonyData.sql
mongo -> telephomyDataMongo.json 
для postman там же `src/main/resources`



## [4](#dont-work) Что НЕ работает

В данный момент не работает удаление в postgres, по номеру телефона.