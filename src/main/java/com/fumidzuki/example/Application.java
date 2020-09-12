package com.fumidzuki.example;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * アプリケーションクラス。
 */
@ApplicationPath("/")
public class Application extends ResourceConfig {

  /**
   * コンストラクタ。
   */
  public Application() {
    // 「multipart/form-data」を受け付けるための設定をします。
    this.register(MultiPartFeature.class);
    this.packages(this.getClass().getPackage().getName());
  }

}
