package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(
                        int id,
                        String title,
                        String image,
                        String published,
                        String genre
                       ) {
}
