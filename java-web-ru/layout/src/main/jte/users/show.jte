@import exercise.dto.users.UserPage
@param UserPage page

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
       <h1>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h1>
       <p>${page.getUser().getEmail()}</p>
    `,
         footer = @`
             <p>
                 <a href="https://github.com/maximkoo/hexlet-assignments">This is Github link</a>
             </p>
         `
)
