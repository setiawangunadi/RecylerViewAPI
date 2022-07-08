package com.example.recylerviewapi

data class MainModel(
    val result: ArrayList<Result>
){
    data class Result (
        val login : String,
        val id : Int,
        val node_id : String,
        val avatar_url : String,
        val gravatar_id : String,
        val url : String,
        val html_url : String,
        val followers_url : String,
        val following_url : String,
        val gits_url : String,
        val starred_url : String,
        val subscriptions_url : String,
        val organizations_url : String,
        val repos_url : String,
        val events_url : String,
        val received_events_url : String,
        val type : String,
        val site_admin : Boolean)
}
