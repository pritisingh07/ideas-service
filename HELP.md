# Getting Started

### Prerequisite
To be able to consume this API, you should already have a local mongodb running. One of the easiest way to do so is to run a mongo image in a docker container. This guide can help you do so - [Run Mongodb in docker](https://sparkbyexamples.com/mongodb/run-mongodb-in-docker-container/) .
You can check if the connection was established by looking for this log-
```
--- [localhost:27017] org.mongodb.driver.cluster               : Monitor thread successfully connected to server with description ServerDescription{address=localhost:27017, type=STANDALONE, state=CONNECTED, ok=true, minWireVersion=0, maxWireVersion=17, maxDocumentSize=16777216, logicalSessionTimeoutMinutes=30, roundTripTimeNanos=9635792}
```

### Overview
The service has two type of API
#### Collections
To create and manage Collections.
A Collection can have sub-collections and list of Ideas.
#### Ideas
To create and manage Ideas
An Idea can belong to a specific collection or to a default collection. Idea can be of mainly 3 types -
1. Text : such as notes, texts
2. Image : This contains url where image is stored.
3. File : This can be a media or a file which was uploaded in S3 bucket before and the user has upload Id which can be used to retrieve the location of this media.

### Endpoints
#### POST /ideas
This endpoint creates a new Idea. 
##### For Idea of `TEXT` type 
the Request body should be like following:
```
{
	"mediaSource" : {
		"mediaSourceType" : "TEXT",
		"text" : "<Your text content here>"
	}
}
```
Response:
with 201 `created`,
```
{
	"id": "36c08928-1d93-40a9-9db2-576d7a2b5dc9",
	"media": {
		"mediaType": "TEXT",
		"imageUrl": null,
		"fileUrl": null,
		"text": "text idea test"
	},
	"createdDate": "2023-08-14T10:48:48.470225",
	"collectionId": null
}
```
HTTP 400` Bad Request`, if `text` field is not sent in the request.

##### For Idea of `IMAGE_URL` type, 
the Request body should be like following:
```
{
	"mediaSource" : {
		"mediaSourceType" : "IMAGE_URL",
		"imageUrl" : "<Your image url here>"
	}
}
```
Response:
with 201 `created`,
```
{
	"id": "54aed849-9f74-47f8-86b5-741367a1bf6c",
	"media": {
		"mediaType": "IMAGE_URL",
		"imageUrl": "http://image.is.here.hi",
		"fileUrl": null,
		"text": null
	},
	"createdDate": "2023-08-14T10:53:04.018029",
	"collectionId": null
}
```
HTTP 400` Bad Request`, if `imageUrl` field is not sent in the request.

##### For Idea of any other media type, 
the Request body should be like following:
```
{
	"mediaSource" : {
		"mediaSourceType" : "FILE_UPLOAD_ID",
		"fileUploadId" : "<Your image url here>"
	}
}
```

Response:
with 201 `created`,
```
{
		"id": "60819ea5-f7f9-4ed4-9be7-800d561c4a81",
		"media": {
			"mediaType": "FILE_URL",
			"imageUrl": null,
			"fileUrl": "https://file.stored.here",
			"text": null
		},
		"createdDate": "2023-08-14T10:23:46.584",
		"collectionId": null
}
```
HTTP 400` Bad Request`, if `fileUploadId` field is not sent in the request.

#### GET /ideas
This endpoint retrieves all Ideas. 
One example of response:
```
[
	{
		"id": "2f6993bf-c5fb-454d-8c25-be737628478d",
		"media": {
			"mediaType": "TEXT",
			"imageUrl": null,
			"fileUrl": null,
			"text": "Hello World new IDea"
		},
		"createdDate": "2023-08-14T10:21:30.457",
		"collectionId": null
	},
	{
		"id": "7793c249-1639-47c4-9505-2b5a89fed92b",
		"media": {
			"mediaType": "IMAGE_URL",
			"imageUrl": "http://image.is.here",
			"fileUrl": null,
			"text": null
		},
		"createdDate": "2023-08-14T10:22:09.475",
		"collectionId": null
	},
	{
		"id": "60819ea5-f7f9-4ed4-9be7-800d561c4a81",
		"media": {
			"mediaType": "FILE_URL",
			"imageUrl": null,
			"fileUrl": "https://file.stored.here",
			"text": null
		},
		"createdDate": "2023-08-14T10:23:46.584",
		"collectionId": null
	}
]
```

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.2/maven-plugin/reference/html/#build-image)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsingle/index.html#howto.data-access.exposing-spring-data-repositories-as-rest)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsingle/index.html#data.nosql.mongodb)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)

