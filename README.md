# CampaignsApp

Android App using Campaigns API

## Description

a simple app that contains some basic functionality. It connects to the Campaigns DB API and fetch current campaigns on there.


## Technologies
- [Dagger 2](https://github.com/google/dagger)
- [Retrofit 2](https://github.com/square/retrofit) - [OkHttp3](https://github.com/square/okhttp)
- [Glide](https://github.com/bumptech/glide)
- [RxJava 2](https://github.com/ReactiveX/RxJava)
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
- [Data Binding](https://developer.android.com/topic/libraries/data-binding)

## Overview of app arch.
- Follow the rules from Architecture guidelines recommended by Google.
- Keep Activity only responsible for UI related code 
- ViewModel provides pure data required by the UI class
- Repository layer provides data to ViewModel classes.
- ViewStates are responsible for reporting changes to the UI.
