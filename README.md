# Overview
*	[Import application](#import-application)
*	[Hibernate required](#hibernate-required)
*	[hibernate flow](#hibernate-flow)
*	[App flow](#app-flow)
*	[About entity](#about-entity)

# Import application

git clone https://Lampart_Thai_Huy_Binh@bitbucket.org/Lampart_Thai_Huy_Binh/hypernate_mysql.git 

![Alt text](doc/Import_app.jpg)

+		Clone git source into folder.
+		Open __Spring tool suite__ select workspace is *hypernate_mysql*'s parent folder path.
+		On IDE screen select __Import__.
+		On __Import__ tab > choose __Gradle/Existing Gradle Project__ then click __Next__ in two times.
+		On __Import Gradle Project__ tab at __project root directory__ bar click __Browse..__
+		Select *hypernate_mysql* folder path which you just extract git url then click Finish as below picture.

![Alt text](doc/finish_import.jpg)

# Hibernate required

![Alt text](doc/Hypernate_required.jpg)

+		On build.gradle need __compile("org.springframework.boot:spring-boot-starter-data-jpa")__
+		On application.properties need __spring.jpa.hibernate.ddl-auto=update__
+		On root folder need mvnw,mvnw.cmd,pom.xml for declare hibernate and Mysql database source

# hibernate flow

![Screenshot](doc/repoCRUD.svg)

# App flow

![Screenshot](doc/hypernate_app.svg)

# About entity

1. 	Entity Types: [Transient - init, Persistent - normally, Detached - working]
	-	If an object has its own database identity (primary key value) then it’s type is Entity Type.
	-	An entity has its own lifecycle. It may exist independently of any other entity.
	-	An object reference to an entity instance is persisted as a reference in the database (a foreign key value).
	-	From the above picture, College is an Entity Type. It has it’s own database identity (It has primary key).

2. 	Value Types:
	-	If an object don’t have its own database identity (no primary key value) then it’s type is Value Type.
	-	Value Type object belongs to an Entity Type Object.
	-	It’s embedded in the owning entity and it represents the table column in the database.
	-	The lifespan of a value type instance is bounded by the lifespan of the owning entity instance.
Key word: 
   Entity : 
   	Entity Types [Transient,Persistent,Detached] 
   	Value Types : [Basic Value Types,Composite Value Types,Collection Value Types]
