# -*- coding: utf-8 -*-
# Generated by Django 1.11.12 on 2018-08-18 08:07
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('WeHealedAPI', '0002_auto_20180818_0801'),
    ]

    operations = [
        migrations.AddField(
            model_name='dictionary',
            name='detail_text',
            field=models.CharField(default=1, max_length=5000),
            preserve_default=False,
        ),
    ]
