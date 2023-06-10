package at.ac.fhcampuswien.fhmdb.api;

import at.ac.fhcampuswien.fhmdb.models.Genre;


public class MovieAPIRequestBuilder {
    private String base;
    private String query;
    private Genre genre;
    private String releaseYear;
    private String ratingFrom;

    private static final String DELIMITER = "&";

    public static class Builder {
        private String base;
        private String query;
        private Genre genre;
        private String releaseYear;
        private String ratingFrom;

        public Builder(String base) {
            this.base = base;
        }

        public Builder query(String query) {
            this.query = query;
            return this;
        }

        public Builder genre(Genre genre) {
            this.genre = genre;
            return this;
        }

        public Builder releaseYear(String releaseYear) {
            this.releaseYear = releaseYear;
            return this;
        }

        public Builder ratingFrom(String ratingFrom) {
            this.ratingFrom = ratingFrom;
            return this;
        }

        public MovieAPIRequestBuilder build() {
            return new MovieAPIRequestBuilder(this);
        }
    }

    private MovieAPIRequestBuilder(Builder builder) {
        this.base = builder.base;
        this.query = builder.query;
        this.genre = builder.genre;
        this.releaseYear = builder.releaseYear;
        this.ratingFrom = builder.ratingFrom;
    }

    public String buildUrl() {
        StringBuilder url = new StringBuilder(base);

        if ( (query != null && !query.isEmpty()) ||
                genre != null || releaseYear != null || ratingFrom != null) {

            url.append("?");

            // check all parameters and add them to the url
            if (query != null && !query.isEmpty()) {
                url.append("query=").append(query).append(DELIMITER);
            }
            if (genre != null) {
                url.append("genre=").append(genre).append(DELIMITER);
            }
            if (releaseYear != null) {
                url.append("releaseYear=").append(releaseYear).append(DELIMITER);
            }
            if (ratingFrom != null) {
                url.append("ratingFrom=").append(ratingFrom).append(DELIMITER);
            }
        }

        return url.toString();
    }
}

