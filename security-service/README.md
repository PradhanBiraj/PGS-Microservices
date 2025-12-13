# Security Service

This service provides authentication and authorization for the General Store application using OAuth2 with GitHub.

## Configuration

To run this service, you need to configure the GitHub OAuth2 credentials in the `docker-compose.yml` file.

1.  Create an OAuth2 application on GitHub. You can follow the instructions [here](https://docs.github.com/en/developers/apps/building-oauth-apps/creating-an-oauth-app).
2.  Set the `Authorization callback URL` to `http://localhost:8085/login/oauth2/code/github`.
3.  Once the application is created, you will get a `Client ID` and a `Client Secret`.
4.  Set the `GITHUB_CLIENT_ID` and `GITHUB_CLIENT_SECRET` environment variables in the `docker-compose.yml` file with the values you got in the previous step.

## Running the service

To run the service, you can use the following command:

```bash
docker-compose up -d security-service
```

## Testing the service

To test the service, you can go to `http://localhost:8085/` in your browser. You will be redirected to GitHub for authentication. After you log in, you will be redirected back to the application and you will see a JSON with your user information.
