1. call the following api to login
Request API:
	http://localhost:8080/login?userName=jwtusername&password=jwtpassword
Request METHOD:
    HTTP GET METHOD
API Response Format:
	{
    "error": null,
    "data": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJqd3R1c2VyaWQiLCJyZWFsTmFtZSI6Imp3dHVzZXJuYW1lIiwiZXhwIjoxNjQwMTk0Mzk1LCJ1c2VyTmFtZSI6Imp3dHBhc3N3b3JkIiwiaWF0IjoxNjQwMTkyNTk1fQ.FA_K-F6Lh4xpv6kTM1YdvOBJReuqg1-ThyTZrQ-e9gM",
    "ok": true
    }
	jwt token is encapsualted in [data] field.
	

2. call the following api to query all accounts
Request API:
    http://localhost:8080/account
Request METHOD:
    HTTP GET METHOD
Request Requirement:
     (1) put the key-value in the request header
	     key：token
	     value: jwt token responsed in step1's [data]field
	 (2) set Content-Type as 'application/json' in the request header
API Response Format:
    {
    "error": null,
    "data": [
        {
            "id": 1,
            "name": "dummy",
            "password": "",
            "gender": 0,
            "birthDate": "1900-01-01 00:00:00",
            "place": "",
            "mobile": "15812345678"
        }
    ],
    "ok": true
    }
	
3. call the following api to query one account
Request API:
    http://localhost:8080/account/{id}
Request METHOD:
    HTTP GET METHOD
Request Requirement:
     (1) put the key-value in the request header
	     key：token
	     value: jwt token responsed in step1's [data]field
	 (2) set Content-Type as 'application/json' in the request header
API Response Format:
    {
    "error": null,
    "data": [
        {
            "id": 1,
            "name": "dummy",
            "password": "",
            "gender": 0,
            "birthDate": "1900-01-01 00:00:00",
            "place": "",
            "mobile": "15812345678"
        }
    ],
    "ok": true
    }
	
4. call the following api to create a new account
Request API:
    http://localhost:8080/account
Request METHOD:
    HTTP POST METHOD
Request JSON Format:
	{
		"id":2,
		"name":"baby",
		"password":"1234567890123450",
		"gender":2,
		"place":"shanghai",
		"birthDate":"1980-01-01",
		"mobile":"123mo3"
	}
Request Requirement:
     put the key-value in the request header
     (1) put the key-value in the request header
	     key：token
	     value: jwt token responsed in step1's [data]field
	 (2) set Content-Type as 'application/json' in the request header
API Response Format:
	{
		"error": null,
		"data": {
			"id": 2,
			"name": "baby",
			"password": "1234567890123450",
			"gender": 2,
			"birthDate": "1980-01-01",
			"place": "shanghai",
			"mobile": "123mo3"
		},
		"ok": true
	}
	
5. call the following api to delete one account
Request API:
    http://localhost:8080/account/{id}
Request METHOD:
    HTTP DELETE METHOD
Request Requirement:
     put the key-value in the request header
     (1) put the key-value in the request header
	     key：token
	     value: jwt token responsed in step1's [data]field
	 (2) set Content-Type as 'application/json' in the request header
API Response Format:
	{
		"error": null,
		"data": null,
		"ok": true
	}

