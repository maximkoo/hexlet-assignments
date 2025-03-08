@import exercise.dto.posts.PostPage
@param PostPage page

@template.layout.page(
    content = @`
        <div class="mx-auto p-4 py-md-5">
            <main>
            <p><h2>${page.getPost().getName()}</h2></p>
            <p>${page.getPost().getBody()}</p>
            </main>
        </div>
    `
)