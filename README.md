# RetrofitModule
Android Retrofit Module in Java language + Single Screen App to test

# **Usage** 
***
[1] **Add the following permissions to Manifest** 

    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
***
[2] **Add the following dependencies to build.gradle(ProjectModule)** 

    // Dependency to use Retrofit Library(Gives Asynchronous network request)
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    // Dependency to use GSON as notation while converting from JSON->POJO
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    
    
    /* INCASE OF USING RXJAVA */
    // RXJava dependencies
    def rxJavaVersion="2.1.1"
    implementation "io.reactivex.rxjava2:rxandroid:$rxJavaVersion"
    implementation "io.reactivex.rxjava2:rxjava:$rxJavaVersion"
    // RXJava + Retrofit  [Adapter]
    implementation 'com.squareup.retrofit2:adapter-rxjava2:2.7.1'
    
***
[3] **Put [SingletonRetroficClient class](https://github.com/mossssama/RetrofitModule/blob/main/RetrofitModule/app/src/main/java/com/example/retrofitmodule/API/SingletonRetrofitClient.java) in your app folder**
***
[4] **Test the request using [Postman](https://dark-station-716019.postman.co/workspace/OsOs~420c5ec5-8edf-4eed-8fc2-928256fb3f30/request/create?requestId=fed947dc-2c8f-4779-9bde-4d492f8292ce) to generate JSON response**
***
[5] **Convert JSON response to POJO using [JSON->POJO](https://www.jsonschema2pojo.org/) (choose JSON as sourcetype & Gson as annotation style) & generate zip file & paste it to app folder**
***
[6] **Put [Api interface](https://github.com/mossssama/RetrofitModule/blob/main/RetrofitModule/app/src/main/java/com/example/retrofitmodule/API/Api.java) in your app (update BASE_URL + update functions return by your POJO)**
***
[7] **Copy the following code where you want to make an API request**
 
     /* Sending request & reading response */

        /*[1] No RXJava with Retrofit*/
        Call<Verse> apiResponse = SingletonRetrofitClient.getInstance().getApi().getVerse(5);

        apiResponse.enqueue(new Callback<Verse>() {
            @Override
            public void onResponse(Call<Verse> call, Response<Verse> response) {
                Toast.makeText(MainActivity.this, response.body().getData().getText(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Verse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        /*[2] RXJava with Retrofit */
     /* Observable apiResponse=SingletonRetrofitClient.getInstance().getApi().getVerse(5).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    
        Observer<Verse> observer=new Observer<Verse>() {
             @Override
             public void onSubscribe(Disposable d) {}
    
             @Override
             public void onNext(Verse verse) {
                 Toast.makeText(MainActivity.this, verse.getData().getText(), Toast.LENGTH_SHORT).show();
             }
      
             @Override
             public void onError(Throwable e) {
                 Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
             }
      
             @Override
             public void onComplete() {}
         };
      
         apiResponse.subscribe(observer);   */
***
***
# NOTES ABOUT RESTFUL APIs & Retrofit

## API : WebService provided by remote servers & developed by backEnd developers ##
- They are set of methods/classes build in any scripting language & can be used without knowing their implementation
- We needs agreement/protocol & key to use an API
## They are provided in different protocols & architectures as: ##
- Protocols(TCP/IP): 1-HTTP 2-SMTP 3-FTP
- Architectures: 1-REST 2-SOAP
- App -FTP/SMTP/HTTP-> Server (API Request)
- App <-XML/HTML/JSON- Server (API Response)

    |    vs    |    SOAP   |      REST     |
    |:--------:|:---------:|:-------------:|
    |  Request | HTTP/SMTP |      HTTP     |
    | Response |    XML    | XML/HTML/JSON |
    | Security |    High   |      Low      |
## API response return with code (code & information in case of successful request) as the following ##

    | Response Code |         Meaning        |
    |---------------|------------------------|
    |    100->199   | Informational response |
    |    200->299   |   Successful response  |
    |    300->399   |        Redirects       |
    |    400->499   |      Client errors     |
    |    500->599   |      Server errors     |
## APIs request must support Asynchronous code to get red of application stuck during waiting for API response ##
We have two Android libraries supporting Asychronous code
- Volley: official documented library
- Retrofit: part of JetPack Compose;libraries & best practices revelead by Google in 2019




