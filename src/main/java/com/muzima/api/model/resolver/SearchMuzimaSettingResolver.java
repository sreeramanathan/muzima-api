package com.muzima.api.model.resolver;

import com.muzima.api.model.algorithm.MuzimaSettingAlgorithm;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

public class SearchMuzimaSettingResolver extends BaseOpenmrsResolver {
    private static final String REPRESENTATION
            = "?v=custom:"+ MuzimaSettingAlgorithm.STANDARD_SETTING_REPRESENTATION;

    public String resolve(final Map<String, String> resourceParams) throws IOException {
        StringBuilder paramBuilder = new StringBuilder();
        for (String key : resourceParams.keySet()) {
            paramBuilder.append("&").append(key).append("=").append(URLEncoder.encode(resourceParams.get(key), "UTF-8"));
        }
        return getConfiguration().getServer() + "/ws/rest/v1/muzima/setting" + REPRESENTATION + paramBuilder.toString();
    }
}
