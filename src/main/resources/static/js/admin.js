function userList() {
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: location.origin + "/api/admin/userList"
    }).done((data) => {
        $.each(data, (index, item) => {
            $("#zero_config tbody").prepend(`
                <tr id="user_${item.id}" style="text-align: center">
                    <td>${item.id}</td>
                    <td>${item.fullName}</td>
                    <td>${item.email}</td>
                    <td>${item.gender == "F" ? "Female":"Male"}</td>
                    <td>${item.status ? "Active":"Locked"}</td>
                    <td>
                        <a data-id="${item.id}" class="delete" data-toggle="modal">
                                <i style="${(item.status)?'':'color: #95a5a6'}"
                                   class="${(item.status)?'fa fa-unlock-alt':'fa fa-lock'}"
                                   aria-hidden="true">
                                </i>
                        </a>
                    </td>
                </tr>
            `)
        });
    })
}



$(document).ready(function () {
    userList();
})