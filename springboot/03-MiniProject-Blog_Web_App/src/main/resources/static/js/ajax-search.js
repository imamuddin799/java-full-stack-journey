$(function() {
	function renderBlogs(blogs) {
		const list = $('#blogList');
		list.empty();
		if (!blogs || blogs.length === 0) {
			list.append(`<div class="col-12"><div class="alert alert-info">No results.</div></div>`);
			return;
		}
		blogs.forEach(b => {
			const card = `
        <div class="col-md-9 mb-3">
          <div class="card h-100">
            <div class="card-body">
              <h5 class="card-title">${b.title}</h5>
              <p class="card-text">${b.shortDescription}</p>
              <a href="/blogs/${b.id}" class="btn btn-sm btn-primary">Read More</a>
            </div>
            <div class="card-footer text-muted">
			<span>${new Date(b.createdAt).toLocaleDateString('en-GB', { day: '2-digit', month: 'short', year: 'numeric' })}</span>
            </div>
          </div>
        </div>`;
			list.append(card);
		});
	}

	$('#searchBtn').on('click', function() {
		const q = $('#searchInput').val().trim();
		if (!q) return;
		$.get('/search', { q }, renderBlogs);
	});

	$('#searchInput').on('keypress', function(e) {
		if (e.which === 13) $('#searchBtn').click();
	});
});