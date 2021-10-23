class User {
    constructor(id, email, password, firstName, lastName, dateOfBirth, gender, city, country, image, background) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.city = city;
        this.country = country;
        this.image = image;
        this.background = background
    }

}

class Post {
    constructor(id, createdAt, user, content, type) {
        this.id = id;
        this.createdAt = createdAt
        this.content = content;
        this.user = user;
        this.type = type;

    }
}

class Image {
    constructor(id, url) {
        this.id = id;
        this.url = url;
    }
}

class Like {
    constructor(id, user, post) {
        this.id = id;
        this.user = user;
        this.post = post;
    }
}

class Comment {
    constructor(id, user, post, content) {
        this.id = id;
        this.user = user;
        this.post = post;
        this.content = content;
    }
}