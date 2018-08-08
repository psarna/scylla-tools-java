/*
 * Copyright 2016 Cloudius Systems
 *
 * Modified by Cloudius Systems
 */

/*
 * This file is part of Scylla.
 *
 * See the LICENSE.PROPRIETARY file in the top-level directory for licensing information.
 */

package com.scylladb.tools;

import java.net.InetAddress;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.cassandra.config.CFMetaData;
import org.apache.cassandra.db.DecoratedKey;
import org.apache.cassandra.dht.IPartitioner;
import org.apache.cassandra.dht.Range;
import org.apache.cassandra.dht.Token;

interface Client {

    void close();

    Client copy();

    CFMetaData getCFMetaData(String keyspace, String cfName);

    Map<InetAddress, Collection<Range<Token>>> getEndpointRanges();

    IPartitioner getPartitioner();

    void processStatment(DecoratedKey key, long timestamp,
            String what, List<Object> objects);

}
