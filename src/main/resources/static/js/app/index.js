$(function () {
    const $postsRegisterButton = $('#btn-register');
    const $postsRegisterArea = $('.posts-register');

    const $postsModifyButton = $('#btn-modify');
    const $postsModifyArea = $('.posts-modify');

    const $postsDeleteButton = $('#btn-delete');

    const index = new Index($postsRegisterArea, $postsModifyArea);

    $postsRegisterButton.on('click', function () {
        index.postsRegisterAction();
    });

    $postsModifyButton.on('click', function () {
        index.postsModifyAction();
    });

    $postsDeleteButton.on('click', function () {
        index.postsDeleteAction();
    })

});

class Index {

    constructor($postsRegisterArea, $postsModifyArea) {
        this.$postsRegisterArea = $postsRegisterArea;
        this.$postsModifyArea = $postsModifyArea;
    }

    postsRegisterAction() {
        const data = {}
        const $postsRegisterArea = this.$postsRegisterArea;
        $postsRegisterArea.find('[name]').each(function () {
            const $target = $(this);
            data[$target.attr('name')] = $target.val();
        });
        this.sendData('/api/v1/posts', 'POST', data, () => {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        });
    }

    postsModifyAction() {
        const data = {}
        const $postsModifyArea = this.$postsModifyArea;
        const postsId = $postsModifyArea.find('#id').val();
        $postsModifyArea.find('[name]').each(function () {
            const $target = $(this);
            data[$target.attr('name')] = $target.val();
        });
        this.sendData('/api/v1/posts/' + postsId, 'PUT', data, () => {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        });
    }

    postsDeleteAction() {
        const postsId = this.$postsModifyArea.find('#id').val();

        this.sendData('/api/v1/posts/' + postsId, 'DELETE', {}, () => {
            alert('글이 삭제 되었습니다.');
            window.location.href = '/';
        });
    }

    sendData(url, method = 'GET', data={}, callback) {

        $.ajax({
            type: method,
            url: url,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            callback();
        }).fail(function (error) {
            alert(JSON.parse(error));
        });
    }

}


