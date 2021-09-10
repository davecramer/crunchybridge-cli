package com.crunchydata.bctl.service;

import com.crunchydata.model.Credentials;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;


public class CredentialMessageBodyWriter implements MessageBodyWriter<Credentials> {
    /**
     * Ascertain if the MessageBodyWriter supports a particular type.
     *
     * @param type        the class of instance that is to be written.
     * @param genericType the type of instance to be written, obtained either
     *                    by reflection of a resource method return type or via inspection
     *                    of the returned instance. {@link GenericEntity}
     *                    provides a way to specify this information at runtime.
     * @param annotations an array of the annotations attached to the message entity instance.
     * @param mediaType   the media type of the HTTP entity.
     * @return {@code true} if the type is supported, otherwise {@code false}.
     */
    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return type.isInstance(Credentials.class);
    }

    /**
     * Write a type to an HTTP message. The message header map is mutable
     * but any changes must be made before writing to the output stream since
     * the headers will be flushed prior to writing the message body.
     *
     * @param credentials  the instance to write.
     * @param type         the class of instance that is to be written.
     * @param genericType  the type of instance to be written. {@link GenericEntity}
     *                     provides a way to specify this information at runtime.
     * @param annotations  an array of the annotations attached to the message entity instance.
     * @param mediaType    the media type of the HTTP entity.
     * @param httpHeaders  a mutable map of the HTTP message headers.
     * @param entityStream the {@link OutputStream} for the HTTP entity. The
     *                     implementation should not close the output stream.
     * @throws IOException             if an IO error arises.
     * @throws WebApplicationException if a specific HTTP error response needs to be produced.
     *                                 Only effective if thrown prior to the message being committed.
     */
    @Override
    public void writeTo(Credentials credentials, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        entityStream.write(("client-id: "+credentials.getClientId()).getBytes());
        entityStream.write((",client_secret: " + credentials.getClientSecret()).getBytes());
    }
}
