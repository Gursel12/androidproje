package com.example.gursel.newproject.RestApi;

public class BaseManager {
    protected RestApi getRestApiClient()
    {

        RestApiClient restApiClient=new RestApiClient(BaseUrl.Base_URL);
        return restApiClient.getRestApi();

    }
}
