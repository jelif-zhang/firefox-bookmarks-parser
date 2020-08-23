package com.jelif.fbp

import groovy.sql.Sql
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired

import javax.sql.DataSource

@Slf4j
class BookmarkService {

    @Autowired
    DataSource dataSource

    def getBookmarks(kw) {
        def sql = new Sql(dataSource)
        def query = "SELECT moz_bookmarks.title, moz_places.url from moz_bookmarks, moz_places where moz_bookmarks.fk = moz_places.id"
        if (kw) {
            query = "${query} and (moz_bookmarks.title like '%${kw}%' or moz_places.url like '%${kw}%')"
        }
        log.info(query)
        sql.rows(query.toString())
    }
}
