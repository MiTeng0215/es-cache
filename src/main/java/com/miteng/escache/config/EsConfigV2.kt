//package com.miteng.escache.config
//
//import org.apache.http.HttpHost
//import org.apache.http.auth.AuthScope
//import org.apache.http.auth.UsernamePasswordCredentials
//import org.apache.http.client.CredentialsProvider
//import org.apache.http.impl.client.BasicCredentialsProvider
//import org.elasticsearch.client.RestClient
//import org.elasticsearch.client.RestHighLevelClient
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//
//
//class EsConfigV2 {
//    @Configuration
//    class ElasticSearchClient {
//
//
//        @Bean
//        val client: RestHighLevelClient
//            get() {
//                val hosts = hosts!!.split(",".toRegex()).toTypedArray()
//                val httpHosts = arrayOfNulls<HttpHost>(hosts.size)
//                for (i in hosts.indices) {
//                    httpHosts[i] = HttpHost(hosts[i], 9200, "http")
//                }
//                val credentialsProvider: CredentialsProvider = BasicCredentialsProvider()
//                credentialsProvider.setCredentials(AuthScope.ANY, UsernamePasswordCredentials(userName, password))
//                val builder = RestClient.builder(*httpHosts).setRequestConfigCallback { requestConfigBuilder ->
//                    requestConfigBuilder.setConnectTimeout(-1)
//                    requestConfigBuilder.setSocketTimeout(-1)
//                    requestConfigBuilder.setConnectionRequestTimeout(-1)
//                    requestConfigBuilder
//                }.setHttpClientConfigCallback { httpClientBuilder ->
//                    httpClientBuilder.disableAuthCaching()
//                    httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider)
//                }.setMaxRetryTimeoutMillis(5 * 60 * 1000)
//                return RestHighLevelClient(builder)
//            }
//    }
//}