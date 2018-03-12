package com.muzima.api.model.algorithm;

import com.muzima.api.model.MuzimaSetting;
import com.muzima.search.api.model.object.Searchable;
import com.muzima.util.JsonUtils;
import net.minidev.json.JSONObject;

import java.io.IOException;

public class MuzimaSettingAlgorithm extends BaseOpenmrsAlgorithm {

    public static final String STANDARD_SETTING_REPRESENTATION = "(uuid,name,description,valueBoolean,valueString,property,settingDataType,retired)";
    @Override
    public Searchable deserialize(final String serialized, final boolean isFullSerialization) throws IOException {
        MuzimaSetting muzimaSetting = new MuzimaSetting();
        muzimaSetting.setUuid(JsonUtils.readAsString(serialized, "$['uuid']"));
        muzimaSetting.setName(JsonUtils.readAsString(serialized, "$['name']"));
        muzimaSetting.setRetired(JsonUtils.readAsBoolean(serialized, "$['retired']"));
        muzimaSetting.setDescription(JsonUtils.readAsString(serialized, "$['description']"));
        muzimaSetting.setValueBoolean(JsonUtils.readAsBoolean(serialized, "$['valueBoolean']"));
        muzimaSetting.setValueString(JsonUtils.readAsString(serialized, "$['valueString']"));
        muzimaSetting.setSettingDataType(JsonUtils.readAsString(serialized, "$['settingDataType']"));
        muzimaSetting.setProperty(JsonUtils.readAsString(serialized, "$['property']"));
        return muzimaSetting;
    }
    @Override
    public String serialize(final Searchable object, final boolean isFullSerialization) throws IOException {
        MuzimaSetting muzimaSetting = (MuzimaSetting) object;
        JSONObject jsonObject = new JSONObject();
        JsonUtils.writeAsString(jsonObject, "uuid", muzimaSetting.getUuid());
        JsonUtils.writeAsString(jsonObject, "name", muzimaSetting.getName());
        JsonUtils.writeAsBoolean(jsonObject, "retired", muzimaSetting.getRetired());
        JsonUtils.writeAsString(jsonObject, "description", muzimaSetting.getDescription());
        JsonUtils.writeAsBoolean(jsonObject, "valueBoolean", muzimaSetting.getValueBoolean());
        JsonUtils.writeAsString(jsonObject, "valueString", muzimaSetting.getValueString());
        JsonUtils.writeAsString(jsonObject, "settingDataType", muzimaSetting.getSettingDataType());
        JsonUtils.writeAsString(jsonObject, "property", muzimaSetting.getProperty());
        return jsonObject.toJSONString();
    }
}