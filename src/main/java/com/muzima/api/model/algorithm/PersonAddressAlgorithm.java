package com.muzima.api.model.algorithm;

import com.muzima.api.model.PersonAddress;
import com.muzima.search.api.model.object.Searchable;
import com.muzima.util.JsonUtils;
import net.minidev.json.JSONObject;

import java.io.IOException;

public class PersonAddressAlgorithm extends BaseOpenmrsAlgorithm {
    public static final String PERSON_ADDRESS_REPRESENTATION = "(uuid,preferred,address1,address2," +
            "cityVillage,stateProvince,country,postalCode,countyDistrict,address3,address4,address5,address6," +
            "startDate,endDate,latitude,longitude,voided)";

    @Override
    public Searchable deserialize(final String serialized) throws IOException {
        PersonAddress personAddress = new PersonAddress();
        personAddress.setAddress1(JsonUtils.readAsString(serialized, "$['address1']"));
        personAddress.setAddress2(JsonUtils.readAsString(serialized, "$['address2']"));
        personAddress.setAddress3(JsonUtils.readAsString(serialized, "$['address3']"));
        personAddress.setAddress4(JsonUtils.readAsString(serialized, "$['address4']"));
        personAddress.setAddress5(JsonUtils.readAsString(serialized, "$['address5']"));
        personAddress.setAddress6(JsonUtils.readAsString(serialized, "$['address6']"));
        personAddress.setCityVillage(JsonUtils.readAsString(serialized, "$['cityVillage']"));
        personAddress.setCountyDistrict(JsonUtils.readAsString(serialized, "$['countyDistrict']"));
        personAddress.setCountry(JsonUtils.readAsString(serialized, "$['country']"));
        personAddress.setStateProvince(JsonUtils.readAsString(serialized, "$['stateProvince']"));
        personAddress.setPostalCode(JsonUtils.readAsString(serialized, "$['postalCode']"));
        personAddress.setLatitude(JsonUtils.readAsString(serialized, "$['latitude']"));
        personAddress.setLongitude(JsonUtils.readAsString(serialized, "$['longitude']"));
        personAddress.setStartDate(JsonUtils.readAsDate(serialized, "$['startDate']"));
        personAddress.setEndDate(JsonUtils.readAsDate(serialized, "$['endDate']"));
        personAddress.setUuid(JsonUtils.readAsString(serialized, "$['uuid']"));
        personAddress.setPreferred(JsonUtils.readAsBoolean(serialized, "$['preferred']"));
        return personAddress;
    }

    @Override
    public String serialize(final Searchable object) throws IOException {
        PersonAddress personAddress = (PersonAddress) object;
        JSONObject jsonObject = new JSONObject();
        JsonUtils.writeAsString(jsonObject, "address1", personAddress.getAddress1());
        JsonUtils.writeAsString(jsonObject, "address2", personAddress.getAddress2());
        JsonUtils.writeAsString(jsonObject, "address3", personAddress.getAddress3());
        JsonUtils.writeAsString(jsonObject, "address4", personAddress.getAddress4());
        JsonUtils.writeAsString(jsonObject, "address5", personAddress.getAddress5());
        JsonUtils.writeAsString(jsonObject, "address6", personAddress.getAddress6());
        JsonUtils.writeAsString(jsonObject, "cityVillage", personAddress.getCityVillage());
        JsonUtils.writeAsString(jsonObject, "countyDistrict", personAddress.getCountyDistrict());
        JsonUtils.writeAsString(jsonObject, "country", personAddress.getCountry());
        JsonUtils.writeAsString(jsonObject, "stateProvince", personAddress.getStateProvince());
        JsonUtils.writeAsString(jsonObject, "postalCode", personAddress.getPostalCode());
        JsonUtils.writeAsString(jsonObject, "latitude", personAddress.getLatitude());
        JsonUtils.writeAsString(jsonObject, "longitude", personAddress.getLongitude());
        JsonUtils.writeAsDate(jsonObject, "startDate", personAddress.getStartDate());
        JsonUtils.writeAsDate(jsonObject, "endDate", personAddress.getEndDate());
        JsonUtils.writeAsBoolean(jsonObject, "preferred", personAddress.getPreferred());
        JsonUtils.writeAsString(jsonObject, "uuid", personAddress.getUuid());

        return jsonObject.toJSONString();
    }
}
