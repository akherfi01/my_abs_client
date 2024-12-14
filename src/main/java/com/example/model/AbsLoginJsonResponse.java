package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL) // Ignore null fields globally
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore unknown fields globally
public class AbsLoginJsonResponse {

    private User user;
    private String userDefaultLibraryId;
    private ServerSettings serverSettings;
    private String source;

    // Getters and Setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserDefaultLibraryId() {
        return userDefaultLibraryId;
    }

    public void setUserDefaultLibraryId(String userDefaultLibraryId) {
        this.userDefaultLibraryId = userDefaultLibraryId;
    }

    public ServerSettings getServerSettings() {
        return serverSettings;
    }

    public void setServerSettings(ServerSettings serverSettings) {
        this.serverSettings = serverSettings;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL) // Ignore null fields in User
    @JsonIgnoreProperties(ignoreUnknown = true) // Ignore unknown fields in User
    public static class User {

        private String id;
        private String username;
        private String email; // Added to handle "email" field in JSON
        private String type;
        private String token;
        private List<MediaProgress> mediaProgress;
        private List<Object> bookmarks; // Changed to Object to handle complex bookmarks structure
        private boolean isActive;
        private boolean isLocked;
        private long lastSeen;
        private long createdAt;
        private Permissions permissions;
        private List<String> librariesAccessible;
        private List<String> itemTagsAccessible;

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public List<MediaProgress> getMediaProgress() {
            return mediaProgress;
        }

        public void setMediaProgress(List<MediaProgress> mediaProgress) {
            this.mediaProgress = mediaProgress;
        }

        public List<Object> getBookmarks() {
            return bookmarks;
        }

        public void setBookmarks(List<Object> bookmarks) {
            this.bookmarks = bookmarks;
        }

        public boolean isActive() {
            return isActive;
        }

        public void setActive(boolean active) {
            isActive = active;
        }

        public boolean isLocked() {
            return isLocked;
        }

        public void setLocked(boolean locked) {
            isLocked = locked;
        }

        public long getLastSeen() {
            return lastSeen;
        }

        public void setLastSeen(long lastSeen) {
            this.lastSeen = lastSeen;
        }

        public long getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(long createdAt) {
            this.createdAt = createdAt;
        }

        public Permissions getPermissions() {
            return permissions;
        }

        public void setPermissions(Permissions permissions) {
            this.permissions = permissions;
        }

        public List<String> getLibrariesAccessible() {
            return librariesAccessible;
        }

        public void setLibrariesAccessible(List<String> librariesAccessible) {
            this.librariesAccessible = librariesAccessible;
        }

        public List<String> getItemTagsAccessible() {
            return itemTagsAccessible;
        }

        public void setItemTagsAccessible(List<String> itemTagsAccessible) {
            this.itemTagsAccessible = itemTagsAccessible;
        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class MediaProgress {

            private String id;
            private String libraryItemId;
            private String episodeId;
            private double duration;
            private double progress;
            private double currentTime;
            private boolean isFinished;
            private boolean hideFromContinueListening;
            private long lastUpdate;
            private long startedAt;
            private Long finishedAt; // Nullable

            // Getters and Setters
            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLibraryItemId() {
                return libraryItemId;
            }

            public void setLibraryItemId(String libraryItemId) {
                this.libraryItemId = libraryItemId;
            }

            public String getEpisodeId() {
                return episodeId;
            }

            public void setEpisodeId(String episodeId) {
                this.episodeId = episodeId;
            }

            public double getDuration() {
                return duration;
            }

            public void setDuration(double duration) {
                this.duration = duration;
            }

            public double getProgress() {
                return progress;
            }

            public void setProgress(double progress) {
                this.progress = progress;
            }

            public double getCurrentTime() {
                return currentTime;
            }

            public void setCurrentTime(double currentTime) {
                this.currentTime = currentTime;
            }

            public boolean isFinished() {
                return isFinished;
            }

            public void setFinished(boolean finished) {
                isFinished = finished;
            }

            public boolean isHideFromContinueListening() {
                return hideFromContinueListening;
            }

            public void setHideFromContinueListening(boolean hideFromContinueListening) {
                this.hideFromContinueListening = hideFromContinueListening;
            }

            public long getLastUpdate() {
                return lastUpdate;
            }

            public void setLastUpdate(long lastUpdate) {
                this.lastUpdate = lastUpdate;
            }

            public long getStartedAt() {
                return startedAt;
            }

            public void setStartedAt(long startedAt) {
                this.startedAt = startedAt;
            }

            public Long getFinishedAt() {
                return finishedAt;
            }

            public void setFinishedAt(Long finishedAt) {
                this.finishedAt = finishedAt;
            }
        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Permissions {

            private boolean download;
            private boolean update;
            private boolean delete;
            private boolean upload;
            private boolean accessAllLibraries;
            private boolean accessAllTags;
            private boolean accessExplicitContent;

            // Getters and Setters
            public boolean isDownload() {
                return download;
            }

            public void setDownload(boolean download) {
                this.download = download;
            }

            public boolean isUpdate() {
                return update;
            }

            public void setUpdate(boolean update) {
                this.update = update;
            }

            public boolean isDelete() {
                return delete;
            }

            public void setDelete(boolean delete) {
                this.delete = delete;
            }

            public boolean isUpload() {
                return upload;
            }

            public void setUpload(boolean upload) {
                this.upload = upload;
            }

            public boolean isAccessAllLibraries() {
                return accessAllLibraries;
            }

            public void setAccessAllLibraries(boolean accessAllLibraries) {
                this.accessAllLibraries = accessAllLibraries;
            }

            public boolean isAccessAllTags() {
                return accessAllTags;
            }

            public void setAccessAllTags(boolean accessAllTags) {
                this.accessAllTags = accessAllTags;
            }

            public boolean isAccessExplicitContent() {
                return accessExplicitContent;
            }

            public void setAccessExplicitContent(boolean accessExplicitContent) {
                this.accessExplicitContent = accessExplicitContent;
            }
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ServerSettings {

        private String id;
        private boolean scannerFindCovers;
        private String scannerCoverProvider;

        // Other fields omitted for brevity...

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isScannerFindCovers() {
            return scannerFindCovers;
        }

        public void setScannerFindCovers(boolean scannerFindCovers) {
            this.scannerFindCovers = scannerFindCovers;
        }

        public String getScannerCoverProvider() {
            return scannerCoverProvider;
        }

        public void setScannerCoverProvider(String scannerCoverProvider) {
            this.scannerCoverProvider = scannerCoverProvider;
        }
    }
}
