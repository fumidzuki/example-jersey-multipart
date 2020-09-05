package com.fumidzuki.example;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class Application extends ResourceConfig {

  public Application() {
    // 「multipart/form-data」を受け付けるための設定をします。
    // これを指定しないと「415 Unsupported media type」が返却されます。
    this.register(MultiPartFeature.class);
    this.packages(this.getClass().getPackage().getName());
  }

}
