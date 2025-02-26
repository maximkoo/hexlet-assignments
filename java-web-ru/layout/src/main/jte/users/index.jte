@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    header = @`
                <p>
                    <a href="/">Main page</a>
                </p>
                </p>
                    <a href="/users">Users</a>
                </p>
            `,
    content = @`
        @for(var user : page.getUsers())
            <div>
                <h2>
                    <p><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></p>
                </h2>
                    <p>${user.getEmail()}</p>
            </div>
        @endfor
    `,
         footer = @`
             <p>
                 <a href="https://github.com/maximkoo/hexlet-assignments">This is Github link</a>
             </p>
         `
)
