package com.fumidzuki.example.resources;

import java.io.InputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.BodyPart;
import org.glassfish.jersey.media.multipart.ContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.media.multipart.MultiPart;

/**
 * 「multipart/form-data」を受け取るためのリソースクラス。
 */
@Path("/multipart/upload")
public class MultiPartUploadResource {

  /**
   * ファイルアップロード情報を「FormDataContentDisposition」、「InputStream」で取得します。
   * <p>
   * 「FormDataContentDisposition」のかわりに「ContentDisposition」を使用する「400 BadRequest.」が発生します。
   * </p>
   *
   * @param dispoosition ファイル詳細情報
   * @param is ファイルストリーム
   * @return レスポンス情報
   */
  @POST
  @Path("/form-param")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  public Response uploadFormDataParam(
      @FormDataParam("file") FormDataContentDisposition dispoosition,
      @FormDataParam("file") InputStream is) {
    String fileName = dispoosition.getFileName();
    return Response.ok(fileName).build();
  }

   /**
   * ファイルアップロード情報を「FormDataBodyPart」で取得します。
   *
   * @param bodyPart ファイル情報
   * @return レスポンス情報
   */
   @POST
   @Path("/bodypart")
   @Consumes(MediaType.MULTIPART_FORM_DATA)
   public Response uploadDataBodyPart(@FormDataParam("file") FormDataBodyPart bodyPart) {
   ContentDisposition disposition = bodyPart.getContentDisposition();
   String fileName = disposition.getFileName();
   // 「getValueAs」、「getEntityAs」を内部的に使用しているためどちらを使用しても同じ動作になります。
   // InputStream is = bodyPart.getValueAs(InputStream.class);
   // InputStream is = bodyPart.getEntityAs(InputStream.class);
   return Response.ok(fileName).build();
   }

  /**
   * ファイルアップロード情報を「FormDataMultiPart」で取得します。
   *
   * @param multiPart ファイル情報
   * @return レスポンス情報
   */
  @POST
  @Path("/multipart")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  public Response uploadFormDataMultiPart(MultiPart multiPart) {
    List<BodyPart> bodyParts = multiPart.getBodyParts();
    BodyPart bodyPart = bodyParts.get(0);
    ContentDisposition disposition = bodyPart.getContentDisposition();
    String fileName = disposition.getFileName();
    // InputStream is = bodyPart.getEntityAs(InputStream.class);
    return Response.ok(fileName).build();
  }

}

