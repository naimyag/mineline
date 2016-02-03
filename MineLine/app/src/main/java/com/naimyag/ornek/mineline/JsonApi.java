package com.naimyag.ornek.mineline;

import java.util.ArrayList;
import java.util.List;

import in.itunav.indoormaps.data.Amenity;
import in.itunav.indoormaps.data.Building;
import in.itunav.indoormaps.data.Category;
import in.itunav.indoormaps.data.Floor;
import in.itunav.indoormaps.data.dto.Room;
import in.itunav.indoormaps.data.dto.RoomCategoriesDTO;
import in.itunav.indoormaps.data.dto.SearchDTO;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Streaming;
import rx.Observable;

public interface JsonApi {



    /*
    @GET("/index.php/v1/buildings.json")
    Observable<List<Building>> buildings();

    @GET("/index.php/v1/buildings/{id}/floors.json")
    Observable<List<Floor>> floors(@Path("id") long buildingId);

    @GET("/index.php/v1/buildings/{id}/rooms.json")
    Observable<List<Room>> rooms(@Path("id") long buildingId);

    @GET("/index.php/v1/buildings/{id}/categories.json")
    Observable<ArrayList<Category>> buildingCategories(@Path("id") long buildingId);

    @GET("/index.php/v1/buildings/{id}/floors/amenities.json")
    Observable<ArrayList<Amenity>> buildingAmenities(@Path("id") long buildingId);

    @FormUrlEncoded
    @POST("/index.php/v1/people/search")
    Observable<List<SearchDTO>> searchPeople(@Field("term") String term);

    @FormUrlEncoded
    @POST("/index.php/v1/people/search")
    Observable<List<SearchDTO>> searchPeople(@Field("term") String term, @Field("building") long buildingId);

    @GET("/index.php/v1/floors/{id}/rooms.json")
    Observable<List<Room>> floorRooms(@Path("id") long floorId);

    @GET("/index.php/v1/floors/{id}/categories.json")
    Observable<List<RoomCategoriesDTO>> floorRoomCategories(@Path("id") long floorId);

    @GET("/index.php/v1/search_amenities.json")
    Observable<List<Amenity>> searchAmenities();

    @GET("/index.php/v1/buildings/{id}/amenities/{aid}/rooms.json")
    Observable<List<Room>> searchRooms(@Path("id") long buildingId, @Path("aid") long amenityId);

    @GET("/index.php/v1/buildings/{id}/categories/{cid}/rooms.json")
    Observable<List<Room>> searchRoomsByCategory(@Path("id") long buildingId, @Path("cid") long categoryId);

    @GET("/index.php/v1/buildings/{id}/search/{room}/rooms.json")
    Observable<List<Room>> searchRooms(@Path("id") long buildingId, @Path("room") String room);

    @GET("/index.php/v1/rooms/{id}.json")
    Observable<Room> room(@Path("id") long roomId);

    @GET("/index.php/v1/buildings/{id}.json")
    Observable<Building> building(@Path("id") long buildingId);

    @GET("/index.php/v1/map/{id}")
    @Streaming
    Observable<Response> downloadMap(@Path("id") long buildingId);
    */
}
