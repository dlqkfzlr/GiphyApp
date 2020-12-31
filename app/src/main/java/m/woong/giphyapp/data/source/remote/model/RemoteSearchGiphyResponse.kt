package m.woong.giphyapp.data.source.remote.model

import com.google.gson.annotations.SerializedName


data class RemoteSearchGiphyResponse(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("pagination")
    val pagination: Pagination
) {
    data class Data(
        @SerializedName("analytics")
        val analytics: Analytics,
        @SerializedName("analytics_response_payload")
        val analyticsResponsePayload: String,
        @SerializedName("bitly_gif_url")
        val bitlyGifUrl: String,
        @SerializedName("bitly_url")
        val bitlyUrl: String,
        @SerializedName("content_url")
        val contentUrl: String,
        @SerializedName("embed_url")
        val embedUrl: String,
        @SerializedName("id")
        val id: String,
        @SerializedName("images")
        val images: Images,
        @SerializedName("import_datetime")
        val importDatetime: String,
        @SerializedName("is_sticker")
        val isSticker: Int,
        @SerializedName("rating")
        val rating: String,
        @SerializedName("slug")
        val slug: String,
        @SerializedName("source")
        val source: String,
        @SerializedName("source_post_url")
        val sourcePostUrl: String,
        @SerializedName("source_tld")
        val sourceTld: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("trending_datetime")
        val trendingDatetime: String,
        @SerializedName("type")
        val type: String,
        @SerializedName("url")
        val url: String,
        @SerializedName("user")
        val user: User,
        @SerializedName("username")
        val username: String
    ) {
        data class Analytics(
            @SerializedName("onclick")
            val onclick: Onclick,
            @SerializedName("onload")
            val onload: Onload,
            @SerializedName("onsent")
            val onsent: Onsent
        ) {
            data class Onclick(
                @SerializedName("url")
                val url: String
            )

            data class Onload(
                @SerializedName("url")
                val url: String
            )

            data class Onsent(
                @SerializedName("url")
                val url: String
            )
        }

        data class Images(
            @SerializedName("downsized")
            val downsized: Downsized,
            @SerializedName("downsized_large")
            val downsizedLarge: DownsizedLarge,
            @SerializedName("downsized_medium")
            val downsizedMedium: DownsizedMedium,
            @SerializedName("downsized_small")
            val downsizedSmall: DownsizedSmall,
            @SerializedName("downsized_still")
            val downsizedStill: DownsizedStill,
            @SerializedName("fixed_height")
            val fixedHeight: FixedHeight,
            @SerializedName("fixed_height_downsampled")
            val fixedHeightDownsampled: FixedHeightDownsampled,
            @SerializedName("fixed_height_small")
            val fixedHeightSmall: FixedHeightSmall,
            @SerializedName("fixed_height_small_still")
            val fixedHeightSmallStill: FixedHeightSmallStill,
            @SerializedName("fixed_height_still")
            val fixedHeightStill: FixedHeightStill,
            @SerializedName("fixed_width")
            val fixedWidth: FixedWidth,
            @SerializedName("fixed_width_downsampled")
            val fixedWidthDownsampled: FixedWidthDownsampled,
            @SerializedName("fixed_width_small")
            val fixedWidthSmall: FixedWidthSmall,
            @SerializedName("fixed_width_small_still")
            val fixedWidthSmallStill: FixedWidthSmallStill,
            @SerializedName("fixed_width_still")
            val fixedWidthStill: FixedWidthStill,
            @SerializedName("looping")
            val looping: Looping,
            @SerializedName("original")
            val original: Original,
            @SerializedName("original_mp4")
            val originalMp4: OriginalMp4,
            @SerializedName("original_still")
            val originalStill: OriginalStill,
            @SerializedName("preview")
            val preview: Preview,
            @SerializedName("preview_gif")
            val previewGif: PreviewGif,
            @SerializedName("preview_webp")
            val previewWebp: PreviewWebp,
            @SerializedName("480w_still")
            val wStill: WStill
        ) {
            data class Downsized(
                @SerializedName("height")
                val height: String,
                @SerializedName("size")
                val size: String,
                @SerializedName("url")
                val url: String,
                @SerializedName("width")
                val width: String
            )

            data class DownsizedLarge(
                @SerializedName("height")
                val height: String,
                @SerializedName("size")
                val size: String,
                @SerializedName("url")
                val url: String,
                @SerializedName("width")
                val width: String
            )

            data class DownsizedMedium(
                @SerializedName("height")
                val height: String,
                @SerializedName("size")
                val size: String,
                @SerializedName("url")
                val url: String,
                @SerializedName("width")
                val width: String
            )

            data class DownsizedSmall(
                @SerializedName("height")
                val height: String,
                @SerializedName("mp4")
                val mp4: String,
                @SerializedName("mp4_size")
                val mp4Size: String,
                @SerializedName("width")
                val width: String
            )

            data class DownsizedStill(
                @SerializedName("height")
                val height: String,
                @SerializedName("size")
                val size: String,
                @SerializedName("url")
                val url: String,
                @SerializedName("width")
                val width: String
            )

            data class FixedHeight(
                @SerializedName("height")
                val height: String,
                @SerializedName("mp4")
                val mp4: String,
                @SerializedName("mp4_size")
                val mp4Size: String,
                @SerializedName("size")
                val size: String,
                @SerializedName("url")
                val url: String,
                @SerializedName("webp")
                val webp: String,
                @SerializedName("webp_size")
                val webpSize: String,
                @SerializedName("width")
                val width: String
            )

            data class FixedHeightDownsampled(
                @SerializedName("height")
                val height: String,
                @SerializedName("size")
                val size: String,
                @SerializedName("url")
                val url: String,
                @SerializedName("webp")
                val webp: String,
                @SerializedName("webp_size")
                val webpSize: String,
                @SerializedName("width")
                val width: String
            )

            data class FixedHeightSmall(
                @SerializedName("height")
                val height: String,
                @SerializedName("mp4")
                val mp4: String,
                @SerializedName("mp4_size")
                val mp4Size: String,
                @SerializedName("size")
                val size: String,
                @SerializedName("url")
                val url: String,
                @SerializedName("webp")
                val webp: String,
                @SerializedName("webp_size")
                val webpSize: String,
                @SerializedName("width")
                val width: String
            )

            data class FixedHeightSmallStill(
                @SerializedName("height")
                val height: String,
                @SerializedName("size")
                val size: String,
                @SerializedName("url")
                val url: String,
                @SerializedName("width")
                val width: String
            )

            data class FixedHeightStill(
                @SerializedName("height")
                val height: String,
                @SerializedName("size")
                val size: String,
                @SerializedName("url")
                val url: String,
                @SerializedName("width")
                val width: String
            )

            data class FixedWidth(
                @SerializedName("height")
                val height: String,
                @SerializedName("mp4")
                val mp4: String,
                @SerializedName("mp4_size")
                val mp4Size: String,
                @SerializedName("size")
                val size: String,
                @SerializedName("url")
                val url: String,
                @SerializedName("webp")
                val webp: String,
                @SerializedName("webp_size")
                val webpSize: String,
                @SerializedName("width")
                val width: String
            )

            data class FixedWidthDownsampled(
                @SerializedName("height")
                val height: String,
                @SerializedName("size")
                val size: String,
                @SerializedName("url")
                val url: String,
                @SerializedName("webp")
                val webp: String,
                @SerializedName("webp_size")
                val webpSize: String,
                @SerializedName("width")
                val width: String
            )

            data class FixedWidthSmall(
                @SerializedName("height")
                val height: String,
                @SerializedName("mp4")
                val mp4: String,
                @SerializedName("mp4_size")
                val mp4Size: String,
                @SerializedName("size")
                val size: String,
                @SerializedName("url")
                val url: String,
                @SerializedName("webp")
                val webp: String,
                @SerializedName("webp_size")
                val webpSize: String,
                @SerializedName("width")
                val width: String
            )

            data class FixedWidthSmallStill(
                @SerializedName("height")
                val height: String,
                @SerializedName("size")
                val size: String,
                @SerializedName("url")
                val url: String,
                @SerializedName("width")
                val width: String
            )

            data class FixedWidthStill(
                @SerializedName("height")
                val height: String,
                @SerializedName("size")
                val size: String,
                @SerializedName("url")
                val url: String,
                @SerializedName("width")
                val width: String
            )

            data class Looping(
                @SerializedName("mp4")
                val mp4: String,
                @SerializedName("mp4_size")
                val mp4Size: String
            )

            data class Original(
                @SerializedName("frames")
                val frames: String,
                @SerializedName("hash")
                val hash: String,
                @SerializedName("height")
                val height: String,
                @SerializedName("mp4")
                val mp4: String,
                @SerializedName("mp4_size")
                val mp4Size: String,
                @SerializedName("size")
                val size: String,
                @SerializedName("url")
                val url: String,
                @SerializedName("webp")
                val webp: String,
                @SerializedName("webp_size")
                val webpSize: String,
                @SerializedName("width")
                val width: String
            )

            data class OriginalMp4(
                @SerializedName("height")
                val height: String,
                @SerializedName("mp4")
                val mp4: String,
                @SerializedName("mp4_size")
                val mp4Size: String,
                @SerializedName("width")
                val width: String
            )

            data class OriginalStill(
                @SerializedName("height")
                val height: String,
                @SerializedName("size")
                val size: String,
                @SerializedName("url")
                val url: String,
                @SerializedName("width")
                val width: String
            )

            data class Preview(
                @SerializedName("height")
                val height: String,
                @SerializedName("mp4")
                val mp4: String,
                @SerializedName("mp4_size")
                val mp4Size: String,
                @SerializedName("width")
                val width: String
            )

            data class PreviewGif(
                @SerializedName("height")
                val height: String,
                @SerializedName("size")
                val size: String,
                @SerializedName("url")
                val url: String,
                @SerializedName("width")
                val width: String
            )

            data class PreviewWebp(
                @SerializedName("height")
                val height: String,
                @SerializedName("size")
                val size: String,
                @SerializedName("url")
                val url: String,
                @SerializedName("width")
                val width: String
            )

            data class WStill(
                @SerializedName("height")
                val height: String,
                @SerializedName("size")
                val size: String,
                @SerializedName("url")
                val url: String,
                @SerializedName("width")
                val width: String
            )
        }

        data class User(
            @SerializedName("avatar_url")
            val avatarUrl: String,
            @SerializedName("banner_image")
            val bannerImage: String,
            @SerializedName("banner_url")
            val bannerUrl: String,
            @SerializedName("description")
            val description: String,
            @SerializedName("display_name")
            val displayName: String,
            @SerializedName("instagram_url")
            val instagramUrl: String,
            @SerializedName("is_verified")
            val isVerified: Boolean,
            @SerializedName("profile_url")
            val profileUrl: String,
            @SerializedName("username")
            val username: String,
            @SerializedName("website_url")
            val websiteUrl: String
        )
    }

    data class Meta(
        @SerializedName("msg")
        val msg: String,
        @SerializedName("response_id")
        val responseId: String,
        @SerializedName("status")
        val status: Int
    )

    data class Pagination(
        @SerializedName("count")
        val count: Int,
        @SerializedName("offset")
        val offset: Int,
        @SerializedName("total_count")
        val totalCount: Int
    )
}