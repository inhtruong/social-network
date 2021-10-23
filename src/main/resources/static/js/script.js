const settings = document.querySelector(".settings-menu");
const showSettings = document.querySelector(".nav-user-icon");
const darkMode = document.querySelector(".dark-btn");
const postContent = document.querySelector(".post-content");
const postBtn = document.querySelector(".post-btn");

let user = new User();
let post = new Post();
let page = {
    urls: {
        getAllPost: location.origin + "/api/post"
    },
    loadData: {},
    element: {},
    command: {},
    dialog: {
        loadData: {},
        element: {},
        command: {}
    }
}

showSettings.onclick = function() {
    settings.classList.toggle("active");
}

darkMode.onclick = function() {
    darkMode.classList.toggle("active");
    document.body.classList.toggle("dark-theme");

    if(localStorage.getItem("theme") === "light") {
        localStorage.setItem("theme", "dark");
    } else {
        localStorage.setItem("theme", "light");
    }
}

if (localStorage.getItem("theme") === "light") {
    darkMode.classList.remove("active");
    document.body.classList.remove("dark-theme");
} else if (localStorage.getItem("theme") === "dark") {
    darkMode.classList.add("active");
    document.body.classList.add("dark-theme");
} else {
    localStorage.setItem("theme", "light");
}

postContent.oninput = () => {
    if(postContent.value !== "") {
        postBtn.classList.add("active");
    } else {
        postBtn.classList.remove("active");
    }
};

page.command.postStatus = () => {
    $(".main-content .new-feed").prepend(`
        <div class="post-container">
             <div class="post-row">
                    <div class="user-profile">
                    <img src="images/profile-pic.png" alt="">
                    <div>
                        <p>${user.firstName} ${user.lastName}</p>
                        <span>${post.createdAt}</span>
                    </div>
                </div>
                <a href="#"><i class="fas fa-ellipsis-h"></i></a>
            </div>
            
            <p class="post-text">${post.content}</p>
            <img src="${post.content}" class="post-img">


            <div class="post-row">
                <div class="activity-icons">
                    <div><img src="images/like-blue.png" alt=""> 120</div>
                    <div><img src="images/comments.png" alt=""> 45</div>
                    <div><img src="images/share.png" alt=""> 20</div>
                </div>
                <div class="post-profile-icon">
                    <img src="images/profile-pic.png" alt=""> <i class="fas fa-caret-down"></i>
                </div>
            </div>
        </div>
    `)
}

page.loadData.newFeed = () => {
    $.ajax({
        url: page.urls.getAllPost,
        method: "GET",
        success: function (data) {
            console.log(data)
            $.each(data, (index, item) => {
                post = item;
                user = post.user;
                page.command.postStatus();

            });
        }
    });
}

$(".post-btn").on("click", (e) => {
    e.preventDefault();
    let content = postContent.value;

    if (content !== "") {
        post.content = content;
        page.command.postStatus();
    }
   
});



$(document).ready(() => {
    page.loadData.newFeed();
});
