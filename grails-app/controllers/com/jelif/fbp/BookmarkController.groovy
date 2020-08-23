package com.jelif.fbp


import org.springframework.beans.factory.annotation.Autowired

class BookmarkController {
    static responseFormats = ["json"]

    @Autowired
    BookmarkService bookmarkService;

    def index() {
        header 'Access-Control-Allow-Origin', '*'
        respond bookmarkService.getBookmarks(params.kw)
    }
}
