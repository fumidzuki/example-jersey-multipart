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
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/multipart/upload")
public class MultiPartUploadResource {

  @POST
  @Path("/data-param")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  public Response uploadFormDataParam(@FormDataParam("file") InputStream file,
      @FormDataParam("file") FormDataContentDisposition dispoosition) {
    return Response.ok().build();
  }

  @POST
  @Path("/data-multipart")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  public Response uploadFormDataMultiPart(FormDataMultiPart multiPart) {
    List<BodyPart> bodyParts = multiPart.getBodyParts();
    BodyPart bodyPart = bodyParts.get(0);
    ContentDisposition disposition = bodyPart.getContentDisposition();
    String fileName = disposition.getFileName();
    return Response.ok(fileName).build();
  }


  @POST
  @Path("/data-bodypart")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  public Response uploadDataBodyPart(@FormDataParam("file") FormDataBodyPart bodyPart) {
    return Response.ok().build();
  }


}

