package com.example.android.friendcatalog;

import android.os.AsyncTask;
/**
 * Created by dylan on 11/12/16.
 */

public abstract class FriendCatalogResponse extends AsyncTask<Object,Object,Object>{
    protected Object doInBackground(Object post){
        return post;
    }

    protected void onPostExecuted(Object response){
        onResponse(response);
    }

    protected void onResponse(Object response){

    }
}
