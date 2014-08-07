/*
 * Copyright (c) 2014. The Trustees of Indiana University.
 *
 * This version of the code is licensed under the MPL 2.0 Open Source license with additional
 * healthcare disclaimer. If the user is an entity intending to commercialize any application
 * that uses this code in a for-profit venture, please contact the copyright holder.
 */

package com.muzima.api.dao.impl;

import com.muzima.api.dao.UserDao;
import com.muzima.api.model.User;
import com.muzima.search.api.util.CollectionUtil;
import com.muzima.search.api.util.StringUtil;
import org.apache.lucene.queryParser.ParseException;

import java.io.IOException;
import java.util.List;

public class UserDaoImpl extends OpenmrsDaoImpl<User> implements UserDao {

    private static final String TAG = UserDao.class.getSimpleName();

    protected UserDaoImpl() {
        super(User.class);
    }

    /**
     * Get a user record by the user name of the user.
     *
     * @param username the username of the user.
     * @return user with matching username.
     * @throws ParseException when query parser from lucene unable to parse the query string.
     * @throws IOException    when search api unable to process the resource.
     */
    @Override
    public User getByUsername(final String username) throws ParseException, IOException {
        User user = null;
        StringBuilder query = new StringBuilder();
        if (!StringUtil.isEmpty(username)) {
            query.append("username:").append(username).append(" OR ");
            query.append("systemId:").append(username);
        }
        List<User> users = service.getObjects(query.toString(), daoClass);
        if (!CollectionUtil.isEmpty(users)) {
            if (users.size() > 1) {
                throw new IOException("Unable to uniquely identify a Patient using the identifier");
            }
            user = users.get(0);
        }
        return user;
    }

    /**
     * Get user by the name of the user. Passing empty string will returns all registered users.
     *
     * @param name the partial name of the user or empty string.
     * @return the list of all matching user on the user name.
     * @throws ParseException when query parser from lucene unable to parse the query string.
     * @throws IOException    when search api unable to process the resource.
     */
    @Override
    public List<User> getUserByName(final String name) throws ParseException, IOException {
        StringBuilder query = new StringBuilder();
        if (!StringUtil.isEmpty(name)) {
            query.append("givenName:").append(name).append("*").append(" OR ");
            query.append("middleName:").append(name).append("*").append(" OR ");
            query.append("familyName:").append(name).append("*");
        }
        return service.getObjects(query.toString(), daoClass);
    }
}
