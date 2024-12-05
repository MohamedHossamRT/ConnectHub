package connecthub.interfaces;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME, // Use a type name for mapping
        include = JsonTypeInfo.As.PROPERTY, // Include the type name as a property in JSON
        property = "type" // Property name that specifies the type
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = connecthub.entities.User.class, name = "User"), // User entity
    @JsonSubTypes.Type(value = connecthub.entities.Profile.class, name = "Profile"), // Profile entity
    @JsonSubTypes.Type(value = connecthub.entities.Post.class, name = "Post"), // Post entity
    @JsonSubTypes.Type(value = connecthub.entities.Story.class, name = "Story"), // Story entity
    @JsonSubTypes.Type(value = connecthub.entities.Friend.class, name = "Friend"), // Friend entity
    @JsonSubTypes.Type(value = connecthub.entities.Blocked.class, name = "Blocked"), // Blocked entity
    @JsonSubTypes.Type(value = connecthub.entities.FriendRequest.class, name = "FriendRequest") // Blocked entity
})

public interface Identifiable {

    int getID();
    
    void setID(int id);
    
    String getType();
}
