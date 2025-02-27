@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    header = @`
                <form action="/users" method="get">
                <input type="search" name="term" value="${page.getTerm()}" />
                <input type="submit" value="Search" />
                </form>
    `,
    content = @`
        @for(var user : page.getUsers())
            <div>
                <h2>
                    <p>${user.getFirstName()} ${user.getLastName()}</p>
                </h2>
                    <p>${user.getEmail()}</p>
            </div>
        @endfor
    `
)