function searchList() {
    let keyword= $("#keyword").val();
    $.ajax({
        type: "Post",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: location.origin + "/api/search/list/?keyword=" +keyword,

    }).done((data) => {
        $.each(data, (index, item) => {
            $("#searchList").prepend(`
                <div class="profile-details">
            <div class="pd-left">
                <div class="pd-row">
                    <img src="${item.avatar}" alt="" class="pd-image">
                    <div>
                        <a href="/profile/${item.id}"><span>${item.name}</span></a>
                        <p>120friends - 20 mutual</p>
                        <img src="/images/member-1.png" alt="">
                        <img src="/images/member-2.png" alt="">
                        <img src="/images/member-3.png" alt="">
                        <img src="/images/member-4.png" alt="">
                    </div>
                </div>
            </div>
            <div class="pd-right">
                <button type="button"><img src="/images/add-friends.png" alt=""> Friend</button>
                <button type="button"><img src="/images/message.png" alt=""> Message</button>
                <br>
                <a href="#"><img src="/images/more.png" alt=""></a>
            </div>
        </div>
            `)
        });
    })
}
$(document).ready(function () {
    searchList();
})
